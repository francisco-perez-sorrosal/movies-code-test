Code Test for a Start Up
========================

I quickly implemented this code some months ago for the selection process of a spanish start up.

Problem: Movies App
===================

Imagine you are working for a company that has a movies database in a XML file. The file contains meta-data of several titles, including:
### ID 
### Genre(s) 
### Tags 
### Title 
### Year 
### Director 
### Popularity

The company wants to represent the above data entities in an application in order to classify the movies by:
### Popularity (top - down) 
### Similar movies (same genres and/or tags) 
### Same director

Once the movies are classified, there will be a need to create a playlist of movies for each classification category, the playlist should allow to iterate on the collection by going backwards or forwards.

Solution
========

You should solve this problem using an Object Oriented approach. You should create the XML file and create the mechanism to load the data and convert it into application objects.

The application output should show the different lists of movies that were previously classified, and it will also show an example of a playlist iteration.

Do not use any third-party framework and think about a way to classify those movies depending on some parameters, in a re-usable way and with low complexity.

Author
======

Francisco Perez-Sorrosal :: fperezsorrosal (at) gmail.com :: @fperezsorrosal
