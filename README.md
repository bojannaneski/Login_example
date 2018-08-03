## Login_example
Simple example of Login project that is synced with Google's Firebase. 
Of course you would need to costumize some of the lines of code here into your project. One of the main thing is to synchronize with 
your Firebase account. Once when you open your account on Firebase you will see instructions there but I will also give a small 
brief here.Like you can see on first picture bellow I added classpatch from my Firebase in build.gradle file.</br>

![1](https://user-images.githubusercontent.com/15215620/43668154-bb9b30d0-977b-11e8-9bb1-d802dff232f7.JPG) </br>

, and the second compile link you are adding in build'grade(Module: app) in dependencies { }. First link connects to Firebase and second
link you are getting once when you go to Firebase Authentification, which needs to be turned on for Login methods. The last line of 
code here is a plugin that goes bellow dependencies.</br>

![2](https://user-images.githubusercontent.com/15215620/43666224-3cf3faee-9773-11e8-84dc-d708dc956919.JPG) </br>

Once when you sync it anything else is just yours inspiration, the way how you wanna design it or do the code. I just made a simple 
registration activity</br>
I need to mention also that sometimes libraries versions are not always compatible with what Google gives you, according to maybe your
Android studio version or maybe some supernatural forces what I really start to believe sometimes when Android studio gives me headache.
That's why I added <b>//noinspection GradleCompatible</b> above links so it works and Android studio is not looking for any possible issues.
