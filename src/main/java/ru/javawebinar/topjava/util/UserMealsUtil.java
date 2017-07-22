package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        List<UserMealWithExceed> mealListExceed = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
        for (UserMealWithExceed iter : mealListExceed) {
            System.out.println(iter);
        }
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // create List UserMealWithExceed, wich will be returned
        List<UserMealWithExceed> userMealWithExceedList = new ArrayList<>();
        for (UserMeal iterUserMeal : mealList) {
            if (TimeUtil.isBetween(iterUserMeal.getDateTime().toLocalTime(), startTime, endTime))
                userMealWithExceedList.add(new UserMealWithExceed(
                        iterUserMeal.getDateTime(),
                        iterUserMeal.getDescription(),
                        iterUserMeal.getCalories(),
                        iterUserMeal.getCalories() > caloriesPerDay ? true : false // exceeded calories?
                ));
        }
        return userMealWithExceedList;
    }
}
