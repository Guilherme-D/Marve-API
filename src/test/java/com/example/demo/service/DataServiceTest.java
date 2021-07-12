package com.example.demo.service;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataServiceTest {
    /*
    @MockBean
    private CSSRepository repository;

    @Autowired
    private DataService dataService;

    @Test
    public void whenCreateIsOkForLeftSideNotExists(){

        final DataRequest dataRequest = FakeJson.generateRequest();
        final DataResponse dataResponse = FakeJson.generateResponse();

        when(this.repository.findById(anyLong())).thenReturn(Optional.of(new DataResponse()));
        when(this.repository.save(any(DataResponse.class))).thenReturn(dataResponse);

        final DataResponse response = this.dataService.create(1L, dataRequest, Sides.LEFT);
        assertNotNull(response);

        verify(this.repository, times(1)).findById(anyLong());
        verify(this.repository, times(1)).save(any(DataResponse.class));
    }

    @Test
    public void whenCreateIsOkForRightSideNotExists(){

        final DataRequest dataRequest = FakeJson.generateRequest();
        final DataResponse dataResponse = FakeJson.generateResponse();

        when(this.repository.findById(anyLong())).thenReturn(Optional.of(new DataResponse()));
        when(this.repository.save(any(DataResponse.class))).thenReturn(dataResponse);

        final DataResponse response = this.dataService.create(1L, dataRequest, Sides.RIGHT);
        assertNotNull(response);

        verify(this.repository, times(1)).findById(anyLong());
        verify(this.repository, times(1)).save(any(DataResponse.class));
    }

    @Test
    public void whenCreateIsOkForLeftSideExists(){

        final DataRequest dataRequest = FakeJson.generateRequest();
        final DataResponse dataResponse = FakeJson.generateResponse();

        when(this.repository.findById(anyLong())).thenReturn(Optional.of(dataResponse));
        when(this.repository.save(any(DataResponse.class))).thenReturn(dataResponse);

        final DataResponse response = this.dataService.create(1L, dataRequest, Sides.LEFT);
        assertNotNull(response);

        verify(this.repository, times(1)).findById(anyLong());
        verify(this.repository, times(1)).save(any(DataResponse.class));
    }

    @Test
    public void whenCreateIsOkForRightSideExists(){

        final DataRequest dataRequest = FakeJson.generateRequest();
        final DataResponse dataResponse = FakeJson.generateResponse();

        when(this.repository.findById(anyLong())).thenReturn(Optional.of(dataResponse));
        when(this.repository.save(any(DataResponse.class))).thenReturn(dataResponse);

        final DataResponse response = this.dataService.create(1L, dataRequest, Sides.RIGHT);
        assertNotNull(response);

        verify(this.repository, times(1)).findById(anyLong());
        verify(this.repository, times(1)).save(any(DataResponse.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateAndNotBase64(){

        final DataRequest dataRequest = FakeJson.generateRequest();
        dataRequest.setData("12d'''");

        final DataResponse response = this.dataService.create(1L, dataRequest, Sides.RIGHT);
        assertNull(response);
    }

    @Test(expected = NotFoundException.class)
    public void whenValidateDiffNotFoundId() throws NotFoundException {

        when(this.repository.findById(anyLong())).thenReturn(Optional.empty());

        final String response = this.dataService.validateDiff(1L);
        assertNull(response);

        verify(this.repository, times(1)).findById(anyLong());
    }

    @Test
    public void whenValidateDiffHasLeftAndRightEquals() throws NotFoundException {

        final DataResponse dataResponse = FakeJson.generateResponse();
        dataResponse.setLeftData(dataResponse.getRightData());

        when(this.repository.findById(anyLong())).thenReturn(Optional.of(dataResponse));

        final String response = this.dataService.validateDiff(1L);
        assertNotNull(response);

        verify(this.repository, times(1)).findById(anyLong());
    }

    @Test
    public void whenValidateDiffHasDifferentLeftAndRightSize() throws NotFoundException {

        final DataResponse dataResponse = FakeJson.generateResponse();

        when(this.repository.findById(anyLong())).thenReturn(Optional.of(dataResponse));

        final String response = this.dataService.validateDiff(1L);
        assertNotNull(response);

        verify(this.repository, times(1)).findById(anyLong());
    }
    @Test
    public void whenValidateDiffHasDifferentLeftAndRightButSameSize() throws NotFoundException {

        final DataResponse dataResponse = FakeJson.generateResponse();
        dataResponse.setRightData("ZXNxdWVyZGK=");

        when(this.repository.findById(anyLong())).thenReturn(Optional.of(dataResponse));

        final String response = this.dataService.validateDiff(1L);
        assertNotNull(response);

        verify(this.repository, times(1)).findById(anyLong());
    }
*/


    public static void closest_to_zero(){
        int[] arr = {4,5,6,7,-1};

        int closestIndex = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            int abs = Math.abs(arr[i]);
            if (abs < diff) {
                closestIndex = i;
                diff = abs;
            } else if (abs == diff && arr[i] > 0 && arr[closestIndex] < 0) {
                //same distance to zero but positive
                closestIndex =i;
            }
        }
        System.out.println(arr[closestIndex ]);
        /*
        java8
        int[] str = {2,1,-1,3,-2};
        Arrays.stream(str).filter(i -> i != 0)
                .reduce((a, b) -> abs(a) < abs(b) ? a : (abs(a) == abs(b) ? max(a, b) : b))
                .ifPresent(System.out::println);
        */
    }

    public static void unique_pairs(){
/*
        //(n(n-1))/2 where n is the number of elements

        int n = 5;
        System.out.println((n*(n-1))/2);
*/
        int arr[] = { 1, 2, 2, 4, 2, 5, 3, 5 };
        int n = arr.length;
        // Set to store unique pairs
        Set<Point> s = new HashSet<>();

        // Make all possible pairs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.add(new Point(arr[i], arr[j]));
            }
        }
        System.out.println(s.size());


        //segunda opção
        HashSet<Integer> s2 = new HashSet<>();
        for (int i = 0; i < n; i++)
        {
            s2.add(arr[i]);
        }
        int count = (int) Math.pow(s2.size(), 2);

        System.out.println(s2.size()+"  "+count);


        //opção 3
        int[] ints = Arrays.stream(arr).distinct().toArray();
        int count2 = (int) Math.pow(ints.length, 2);
        System.out.println(ints.length);
    }
    public static void main(String[] args){

        //closest_to_zero();
        unique_pairs();

    }
}
