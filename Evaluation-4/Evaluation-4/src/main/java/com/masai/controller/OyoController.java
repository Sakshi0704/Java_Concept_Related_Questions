package com.masai.controller;

import com.masai.model.Booking;
import com.masai.model.Customer;
import com.masai.model.Hotel;
import com.masai.model.RoomType;
import com.masai.service.OyoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OyoController {
    @Autowired
    private OyoService oyoService ;

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> registerCustomerHandler(@Valid @RequestBody Customer customer){
        Customer customer1 = oyoService.addCustomer(customer) ;
        return new ResponseEntity<>(customer1 , HttpStatus.CREATED) ;
    }

    @PostMapping(value="/hotels")
    public ResponseEntity<Hotel> registerHotelHandler(@Valid @RequestBody Hotel hotel){
        Hotel hotel1 = oyoService.addHotel(hotel) ;
        return new ResponseEntity<>(hotel , HttpStatus.CREATED) ;
    }

    @PostMapping("/bookings/{customerId}/{roomId}/{localDate}")
    public ResponseEntity<Boolean> bookRoomHandler(@PathVariable int customerId ,@PathVariable int roomId ,@PathVariable LocalDate localDate){
        Boolean result = oyoService.makeBooking(customerId , roomId , localDate) ;
        return new ResponseEntity<>(result , HttpStatus.ACCEPTED) ;
    }

    @PostMapping("/roomtypes/{hotelId}")
    public ResponseEntity<RoomType> registerRoomHandler(@Valid @RequestBody RoomType roomType ,@PathVariable int hotelId) {
        RoomType roomType1 = oyoService.addRoomType(roomType , hotelId) ;
        return  new ResponseEntity<>(roomType1 , HttpStatus.CREATED) ;
    }

    @PutMapping("/bookings/{customerId}/{city}/{newRoomId}")
    public ResponseEntity<Boolean> updateBookingHandler(@PathVariable int customerId ,@PathVariable String city ,@PathVariable int newRoomId){
        Boolean result = oyoService.updateBooking(customerId , city , newRoomId) ;
        return new ResponseEntity<>(result , HttpStatus.OK) ;
    }
    @GetMapping("/customers/{customerId}/{day1}/{day2}")
    public ResponseEntity<List<Booking>> getBookingHandler(@PathVariable int customerId , @PathVariable LocalDate day1, @PathVariable LocalDate day2){
        List<Booking> bookingList = oyoService.getBooking(customerId , day1 , day2) ;
        return new ResponseEntity<>(bookingList , HttpStatus.OK) ;
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getHotelList() {
        return new ResponseEntity<List<Hotel>>(oyoService.getHotelList(), HttpStatus.OK);
    }
}
