package org.app.nocodefolio.components.data

import dev.bitspittle.firebase.app.FirebaseApp
import dev.bitspittle.firebase.app.FirebaseOptions


val app = FirebaseApp.initialize(FirebaseOptions(
    apiKey= "AIzaSyDY3zWG2295LX5wE8AbkXDKPW1j-Pe46XY",
    authDomain= "testt-430c7.firebaseapp.com",
    projectId="testt-430c7", storageBucket="testt-430c7.firebasestorage.app",
    messagingSenderId="430761299067", appId="1:430761299067:web:f792cc4064ea149a5626de",
    databaseURL = "https://testt-430c7-default-rtdb.firebaseio.com/",
    measurementId="G-XW6X89B5QR"
))