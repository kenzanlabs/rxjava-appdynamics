package rx.plugins;

public class RxJavaPluginsTest extends RxJavaPlugins {
    public static void resetPlugins() {
        RxJavaPlugins.getInstance().reset();
    }
}
