package com.szberko.hotelreview.service;

import com.szberko.hotelreview.exceptions.HotelNotFoundException;
import com.szberko.hotelreview.provider.HotelProvider;
import com.szberko.hotelreview.repository.HotelRepository;
import com.szberko.hotelreview.repository.model.Hotel;
import com.szberko.hotelreview.service.comparator.HotelNameComparator;
import com.szberko.hotelreview.service.converter.HotelRequestConverter;
import com.szberko.hotelreview.service.converter.HotelResponseConverter;
import com.szberko.hotelreview.service.dto.HotelResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.times;

public class HotelServiceImplTest {

    @Mock private HotelRepository hotelRepository;
    @Mock private HotelResponseConverter hotelResponseConverter;
    @Mock private HotelRequestConverter hotelRequestConverter;
    @Inject
    private HotelNameComparator hotelNameComparator;
    private HotelService hotelService;

    private static Long hotelId = 1L;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.hotelService = new HotelServiceImpl(hotelRepository,
                hotelResponseConverter,
                hotelRequestConverter,
                hotelNameComparator);
    }

    @Test
    public void givenAHotelInDB_whenRetrieveAnExactHotelById_thenReturnServiceLevelResponseObject(){
        final Hotel aRepositoryHotel = HotelProvider.aRepositoryHotel();
        final HotelResponse hotelResponse = HotelProvider.aSeviceHotelResponse();

        Mockito.when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(aRepositoryHotel));
        Mockito.when(hotelResponseConverter.convert(aRepositoryHotel)).thenReturn(hotelResponse);

        assertThat(hotelResponse, equalTo(hotelService.getAHotel(hotelId)));
    }

    @Test(expected = HotelNotFoundException.class)
    public void givenAnEmptyDB_whenRetrieveAnExactHotelById_thenThrowHotelNotFoundException(){
        Mockito.when(hotelRepository.findById(hotelId)).thenThrow(HotelNotFoundException.class);

        hotelService.getAHotel(hotelId);

        Mockito.verify(hotelRepository.findById(hotelId), times(1));
    }

}