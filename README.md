# Similar Users algorithm implementation

Implemented algorithm from the book “Programming Collective Intelligence” by Toby Segaran for showing similarity between two users. 
* Used Euclidean distance formula to calculate similarity. 
* Imported library for reading data from Excel file in Java. 
* Data set have 100 000 user ratings for movies. 

Algorithm returns value between 0.0 and 1.0, if 2 users don't rate the same movies, result will be 0.0, but if the ratings for the common movies are the same, result will be 1.0.
