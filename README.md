# NoteApp
Note App using MVVM and Room Database in Android Studio Using Java

The components which we will be using inside the application are listed below with a detailed explanation : 

LiveData: Live Data is a data holder class that can be observed. It holds as well as caches the latest version of the data and notifies our observer whenever the data is being updated or changed. Live Data automatically manages all of this since it is aware of the relevant lifecycle status changes while observing.

ViewModel: View Modal acts as a communication center between repository and UI. The UI no longer needs to worry about the origin of the data. The ViewModel instances survive Activity/Fragment recreation.

Repository: Repository is a class that is mainly used to manage multiple sources of data.

Entity: Entity is an annotated class that is used to describe a database table when we are working with Room.

Room Database: Room Database is an improvised version of SQLite Database. It simplifies the database work and serves as an access point to the underlying SQLite 
database. The room uses DAO to issue queries to the SQLite database.

DAO: DAO is a Data Access Object which is used for mapping SQL queries to functions.

![Screenshot_2022-04-19-13-35-51-51](https://user-images.githubusercontent.com/99794391/163957044-4a16d0c2-e503-4b53-9143-0cee206c7526.png)
![Screenshot_2022-04-19-13-35-59-44](https://user-images.githubusercontent.com/99794391/163957056-17118d83-7272-4f2c-ad80-b6be2df71a9f.png)
![Screenshot_2022-04-19-13-36-35-06](https://user-images.githubusercontent.com/99794391/163957059-84dbf1c0-1f32-4ea9-ae46-f8b81e7786db.png)
![Screenshot_2022-04-19-13-36-46-17](https://user-images.githubusercontent.com/99794391/163957062-222677ec-3830-4e93-8a60-da5a7bb35489.png)
![Screenshot_2022-04-19-13-37-44-44](https://user-images.githubusercontent.com/99794391/163957066-dc76f856-da54-42ec-abfa-fb812ad76607.png)
![Screenshot_2022-04-19-13-37-51-57](https://user-images.githubusercontent.com/99794391/163957072-5088000c-7963-40ba-ab9e-7ee4dc133e77.png)
