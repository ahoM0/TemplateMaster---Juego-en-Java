package es.instituto.pmdm_ut1_p2

import android.app.Application

import dagger.Component
import dagger.Module
import dagger.Provides
import es.instituto.pmdm_ut1_p2.di.DaggerPersonasComponent
import es.instituto.pmdm_ut1_p2.di.PersonasComponent
import es.instituto.pmdm_ut1_p2.di.PersonasModule
import javax.inject.Inject
import javax.inject.Singleton
class AgendaApp : Application() {

    val appComponent: PersonasComponent by lazy {
       DaggerPersonasComponent.builder().personasModule(PersonasModule()).build()
    }

    override fun onCreate() {
        super.onCreate()

        // Configurar Dagger
        // appComponent.inject(this)
    }
}