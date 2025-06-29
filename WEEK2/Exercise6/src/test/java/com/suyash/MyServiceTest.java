package com.suyash;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Arrange: mock and stub the external dependency
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        // Act: pass the mock to the service
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Assert: verify the result
        assertEquals("Mock Data", result);
    }
}
