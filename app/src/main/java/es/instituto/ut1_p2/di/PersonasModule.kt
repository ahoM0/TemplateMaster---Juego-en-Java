package es.instituto.pmdm_ut1_p2.di
import dagger.Module
import dagger.Provides
import es.instituto.pmdm_ut1_p2.model.PersonasRepository
import javax.inject.Singleton
@Module
class PersonasModule {
    @Singleton
    @Provides
    fun provideMySingleton(): PersonasRepository {
        return PersonasRepository()
    }
}