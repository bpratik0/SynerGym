package dagger;

import com.example.synergym.NewsActivity;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class, RoomModule.class})
public interface NewsComponent {

    void inject(NewsActivity newsActivity);
}
