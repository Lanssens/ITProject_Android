package be.fenego.android_spotshop;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation TestFragment, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@SuppressWarnings("unused")
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @SuppressWarnings("unused")
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under TestFragment.

        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("be.fenego.android_spotshop", appContext.getPackageName());
    }
}
