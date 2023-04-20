package com.example.hotelbooking.Model

class Hotel(
    val name:String,
    val location:String,
    val reviews_num:Int,
    val price_pernight:Int,
    val main_photo:Int,
    var isBooked:Boolean,
    var photo:Int,
    val rating:Double,
    val description:String,
    val isHotels:Boolean,
    val isBathroom2:Boolean,
    var is4Bathroom:Boolean,
    val is4000sqft:Boolean
    ):java.io.Serializable {
}