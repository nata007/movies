package com.cndh.lennkengroup.startactivity.di

import com.cndh.lennkengroup.startactivity.scenes.category.CategoryViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkInjection::class)])
interface ViewModelInjection {

    fun inject(categoryViewModel: CategoryViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjection
        fun networkModule(networkInjecton:NetworkInjection): Builder
    }
}