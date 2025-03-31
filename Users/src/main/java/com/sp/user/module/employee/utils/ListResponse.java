package com.sp.user.module.employee.utils;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@RequiredArgsConstructor
public class ListResponse<T> {

    private final int totalItems;
    private final List<T> items;

    public static <T> ListResponse<T> of(List<T> items){
        return new ListResponse<>(items.size(), items);
    }

    public static <T> ListResponse<T> of(int totalItems, List<T> items ){
        return new ListResponse<>(totalItems, items);
    }

}
