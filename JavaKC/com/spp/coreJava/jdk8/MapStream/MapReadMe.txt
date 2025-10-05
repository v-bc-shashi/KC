
//************************ We can iterate the Map In 5 different ways.  ************************ //
         MapProcesser samObj= new MapProcesser();
         Map<String, String> myMap = samObj.getStringToStringMap();

         System.out.println(myMap.size());


         // *************First WAy
         for (Map.Entry<String, String> myset:myMap.entrySet())  {
           //  System.out.println("Key :"+myset.getKey()+ " Value : "+myset.getValue());

         }

         //************* 2ns Way
         System.out.println("******* 2nd Way**********");
         Iterator itr= myMap.entrySet().iterator();
         while(itr.hasNext()){
             Map.Entry<String, String> myset = (Map.Entry<String, String>)itr.next();
           //  System.out.println("Key :"+myset.getKey()+ " Value : "+myset.getValue());
         }

         //************* 3rd  Way
         System.out.println("******* 3rd  Way*************");
         Set<String> ketSet = myMap.keySet();
         for (String key:ketSet ) {
            // System.out.println("Key :"+key+ " Value : "+ myMap.get(key));
         }

         //************* 4th Way
         System.out.println("******* 4th Way Way*************");
         myMap.keySet().stream().forEach(key-> System.out.println("Key :"+key+ " Value : "+ myMap.get(key)));
     }
//************************ END  ************************ //