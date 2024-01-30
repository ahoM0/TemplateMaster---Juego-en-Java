package es.instituto.pmdm_ut1_p2.di

import dagger.Component
import es.instituto.ut1_p2.DetailActivity
import es.instituto.ut1_p2.MainActivity

import javax.inject.Singleton

@Singleton
@Component(modules = [PersonasModule::class])
interface PersonasComponent {
    fun inject(activity: MainActivity)
   fun inject(activity: DetailActivity)

  //  fun inject(activity: Secondary)
}