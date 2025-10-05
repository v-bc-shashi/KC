          &&&&&&&&&&&&&&&&&&&&&&& List Example of Stream &&&&&&&&&&&&&&&&
------------------------------------------------------------------------------------
##### get ALL the emloyeee Count  whose address is Brazil

  long count= allEmployees.stream().filter(empObj->empObj.getCountry().equals("Brazil")).count();
  Note: Here count() method always return long value. it is directoly aplliable at filter.
------------------------------------------------------------------------------
###### get ALL the emloyeee Count  whose address is Brazil   or US
long count = allEmployees.stream().filter(empObj -> empObj.getCountry().equals("Brazil") || empObj.getCountry().equals("United States")).count();

-------------------------------------------------------------------------------
>>>>>>>>>>>>>>>>>>>>>>get ALL the emloyeee Count  whose address is Brazil   or US WITH PREDICATE <<<<<<<<<<<<<<,

Predicate<Employee> empOfUSANDBrazil = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                if(employee.getCountry().equals("Brazil") || employee.getCountry().equals("United States"))
                return true;
                else
                    return false;
            }
        };

 count= allEmployees.stream().filter(empOfUSANDBrazil).count();
 --------------------------------------------------------------------------------------------

>>>>>>>>>>>> How to get ALl the employee list whose country is brazil and city is Manaus. Using Predicates <<<<<<<<<<<<<<<

Predicate<Employee> brazilManausEmployees = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                if (employee.getCountry().equals("Brazil") && employee.getCity().equals("Manaus"))
                    return true;
                else
                    return false;
            }
        };

List<Employee> AllBrazilManausEmployees = allEmployees.stream().filter(brazilManausEmployees).collect(Collectors.toList());
-------------------------------------------------------------------------------------------------------------------------------
>>>>>>>>>>>. How to List out all the Employee whose city is phonix and increased the AGE by 2 year.<<<<<<<<<<<<<<<
Function<Employee, Employee> AgeIncrimenter= new Function<Employee, Employee>() {
            @Override
            public Employee apply(Employee employee) {
                employee.setEmpAge(employee.getEmpAge()+2);
                return employee;
            }
        };
List<Employee> NewList = allEmployees.stream().filter(empObj-> empObj.getCity().equals("Phoenix")).map(AgeIncrimenter).collect(Collectors.toList());


------------------------------------------

>>>>>>>>>>>>> Collect the List  of City >>>>>>>>>>>>>

List<String >  allCities= allEmpList.stream().collect(Collectors.mapping(employee -> employee.getCity(), Collectors.toList()));

allCities.stream().forEach(System.out::println);
//>>NOTE>>>: Here all Cityinclude duplicat fields as well.

employeeNames = employees.stream().collect(Collectors.mapping(employee -> employee.getName(), Collectors.toList()));

--------------------------------------------------------------------
>>>>>>>>>>>>>>>>>>>>>>>let the SET  of City >>>>>>>>>>>>>>>>>>>>>>>>>>
Set<String >  allCities= allEmpList.stream().collect(Collectors.mapping(employee -> employee.getCity(), Collectors.toSet()));

allCities.stream().forEach(System.out::println);

-------------------------------------------------------------------
>>>>>>>>>>>>>>>.GET all the country from which employee are>>>>>>>>>>>>>>
Set<String> allcountries = allEmpList.stream().map(employee -> employee.getCountry()).collect(Collectors.toSet());

System.out.println("Total countries are : " + allcountries.size());
allcountries.stream().forEach(System.out::println);

--------------------------------------------------------------------------------
>>>>>>>>>>>>>>>Get all the Employee of countrywise >>>>>>>>>>>>>>

Map<String, List<Employee>> countryWiseEmplyee = allEmpList.stream().collect(Collectors.groupingBy(Employee::getCountry));


for(String key: countryWiseEmplyee.keySet()){
           System.out.println("country is :" + key);
           System.out.println("Number Employees are : "+ countryWiseEmplyee.get(key).size());
}
...........output............. :
country is :United States
Number Employees are : 634

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

country is :China
Number Employees are : 227

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

country is :Brazil
Number Employees are : 139

-------------------------------------------------------------------------------------------
>>>>>>>>>>>>>>>Get all the Employee list based of JOb Title >>>>>>>>>>>>>>
Map<String, List<Employee>> countryWiseEmplyee = allEmpList.stream().collect(Collectors.groupingBy(Employee::getJobTitle));
for(String key: countryWiseEmplyee.keySet()){
           System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
           System.out.println("Job Tile is :" + key);
           System.out.println("Number Employees are : "+ countryWiseEmplyee.get(key).size());
       }

..............output is ..............
Job Tile is :Technical Architect
Number Employees are : 13

Job Tile is :Network Engineer
Number Employees are : 14

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

Job Tile is :HRIS Analyst
Number Employees are : 15   ...... like this for all

---------------------------------------------------------------------------------------------------