package com.masai.service;

import com.masai.exception.OYOException;
import com.masai.model.Booking;
import com.masai.model.Customer;
import com.masai.model.Hotel;
import com.masai.model.RoomType;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface OyoService {

    Customer addCustomer(Customer customer) throws OYOException;
    Hotel addHotel(Hotel hotel) throws OYOException;

    boolean makeBooking(int customerId , int roomId , LocalDate bookingDate) throws OYOException ;
    RoomType addRoomType(RoomType roomType , int hotelId) throws OYOException;

    boolean updateBooking(int customerId , String city, int newRoomId) throws OYOException;
    List<Booking> getBooking(int customerId, LocalDate day1 , LocalDate day2) throws OYOException;

    List<Hotel> getHotelList() throws OYOException;
}
