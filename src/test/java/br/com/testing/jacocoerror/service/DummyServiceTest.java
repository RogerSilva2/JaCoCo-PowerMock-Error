package br.com.testing.jacocoerror.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(PowerMockRunner.class)
@SpringBootTest
@PrepareForTest(DummyService.class)
public class DummyServiceTest {

    @InjectMocks
    private DummyService dummyService;

    private File file;

    @Before
    public void setup() throws Exception {
        file = PowerMockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments("test.pdf").thenReturn(file);
    }

    @Test
    public void getFileSuccess() throws IOException {
        PowerMockito.when(file.exists()).thenReturn(true);
        PowerMockito.when(file.isDirectory()).thenReturn(false);

        File fileMock = dummyService.getFile();
        assertThat(fileMock).isNotNull();
    }

    @Test
    public void getFileNotExits() {
        PowerMockito.when(file.exists()).thenReturn(false);

        try {
            dummyService.getFile();
            fail("IOException should have been generated");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IOException.class);
        }
    }

    @Test
    public void getFileIsDirectory() {
        PowerMockito.when(file.exists()).thenReturn(true);
        PowerMockito.when(file.isDirectory()).thenReturn(true);

        try {
            dummyService.getFile();
            fail("IOException should have been generated");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IOException.class);
        }
    }
}