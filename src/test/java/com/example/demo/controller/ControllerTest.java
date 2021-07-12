package com.example.demo.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ControllerTest {
/*
    @Autowired
    private MainController controller;

    @MockBean
    private DataService service;

    @Test
    public void whenCreateLeftIsOkWithoutRight() throws Exception {
        final DataRequest request = FakeJson.generateRequest();

        final DataResponse response = FakeJson.generateResponse();
        response.setRightData(null);

        when(this.service.create(anyLong(), any(DataRequest.class), any(Sides.class))).thenReturn(response);

        final ResponseEntity<DataResponse> controllerLeft = this.controller.createLeft(1L, request);

        assertEquals(controllerLeft.getBody().getLeftData(), request.getData());
        assertNull(controllerLeft.getBody().getRightData());

        Mockito.verify(this.service, Mockito.times(1)).create(1L, request, Sides.LEFT);
    }

    @Test
    public void whenCreateRightIsOkWithoutLeft(){
        final DataRequest request = FakeJson.generateRequest();

        final DataResponse response = new DataResponse();
        response.setLeftData(null);
        response.setRightData(request.getData());

        when(this.service.create(anyLong(), any(DataRequest.class), any(Sides.class))).thenReturn(response);

        final ResponseEntity<DataResponse> controllerRight = this.controller.createRight(1L, request);

        assertEquals(controllerRight.getBody().getRightData(), request.getData());
        assertNull(controllerRight.getBody().getLeftData());

        Mockito.verify(this.service, Mockito.times(1)).create(1L, request, Sides.RIGHT);
    }

    @Test
    public void whenCreateRightWithLeft(){
        final DataRequest request = FakeJson.generateRequest();

        final DataResponse response = FakeJson.generateResponse();
        response.setRightData(request.getData());

        when(this.service.create(anyLong(), any(DataRequest.class), any(Sides.class))).thenReturn(response);

        final ResponseEntity<DataResponse> controllerRight = this.controller.createRight(1L, request);

        assertEquals(controllerRight.getBody().getRightData(), request.getData());
        assertNotNull(controllerRight.getBody().getLeftData());

        Mockito.verify(this.service, Mockito.times(1)).create(1L, request, Sides.RIGHT);
    }

    @Test
    public void whenCreateLeftWithRight() throws Exception {
        final DataRequest request = FakeJson.generateRequest();

        final DataResponse response = FakeJson.generateResponse();

        when(this.service.create(anyLong(), any(DataRequest.class), any(Sides.class))).thenReturn(response);

        final ResponseEntity<DataResponse> controllerLeft = this.controller.createLeft(1L, request);

        assertEquals(controllerLeft.getBody().getLeftData(), request.getData());
        assertNotNull(controllerLeft.getBody().getRightData());

        Mockito.verify(this.service, Mockito.times(1)).create(1L, request, Sides.LEFT);
    }

    @Test
    public void whenValidateDiffHasLeftAndRightEquals() throws NotFoundException {

        when(this.service.validateDiff(anyLong())).thenReturn("Documentos 1 idênticos.");

        final ResponseEntity<String> stringResponseEntity = this.controller.validateDiff(1L);

        assertEquals(stringResponseEntity.getBody(), "Documentos 1 idênticos.");
    }

    @Test
    public void whenValidateDiffHasDifferentLeftAndRightSize() throws NotFoundException {

        when(this.service.validateDiff(anyLong())).thenReturn("Documentos 1 com tamanhos diferentes.");

        final ResponseEntity<String> stringResponseEntity = this.controller.validateDiff(1L);

        assertEquals(stringResponseEntity.getBody(), "Documentos 1 com tamanhos diferentes.");
    }

    @Test
    public void whenValidateDiffHasDifferentLeftAndRightButSameSize() throws NotFoundException {

        when(this.service.validateDiff(anyLong())).thenReturn("Os dados se diferem na posição 8");

        final ResponseEntity<String> stringResponseEntity = this.controller.validateDiff(1L);

        assertEquals(stringResponseEntity.getBody(), "Os dados se diferem na posição 8");
    }*/
}
