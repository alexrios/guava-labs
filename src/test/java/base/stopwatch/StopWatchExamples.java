package base.stopwatch;

import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StopWatchExamples {

    @Test
    public void usando_cronometro() throws Exception {
        Ticker ticker = Mockito.mock(Ticker.class);
        Mockito.when(ticker.read()).thenReturn(0L, 20000000L);

        Stopwatch stopwatch = Stopwatch.createUnstarted(ticker);
        stopwatch.start();
        stopwatch.stop();

        assertThat(stopwatch.elapsed(TimeUnit.MILLISECONDS), is(20L));
    }
}
