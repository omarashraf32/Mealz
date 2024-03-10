package com.example.domain.usecase

import com.example.domain.repo.MealsRepo

class GetMealz(private val mealsRepo: MealsRepo) {
    suspend operator fun invoke() = mealsRepo.getMealsFromRemote()
   // hna anta ht2der tst5dam el fun el gwa el class 3ltol mosh lazem tnady 3la 5las bt3ah el 2wal
}