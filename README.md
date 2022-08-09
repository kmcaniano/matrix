
# Extendable Matrix Implementation Design

The goal of this project is to create a framework of performing Matrix operations that are easily extendable to new implemnations created by a user. This implemntation supports single and multi-dimensional matricies.

Many libraries that handle Matrix operations are very limited in their scope. Either it is limited to primitives or to predetermined classes. I want the ability to allow for users to create their own classes and have the ability to put it in a Matrix.

I originally designed this many years ago in Python, but I have since lost that code. Using Python is a bit easier because it supports operator overloadding. I decided to redo this project in Java because the design is more challenging.


# Design
All values that can be stored in a Matrix must extend the Element interface. The Element interface contains the operations that a Matrix can perform on its elements. The use of generics in this interface allows for this implementation to be extended to many use cases.

Matrix operations are possible because it also extends the Element interface. 

This implementation makes it very easy to perform operations on n-dimensional matricies. A 3-dimensional matrix would have the implementation of Matrix<Matrix<YourElement>>.


# Extendability Example
An image is a multi-dimensional matrix of RGB values. A 500x500 image can be seen as a 500x500 matrix consisting of 1x3 matricies that contain the RGB values of each pixel. 

Through this design we can define unique operations for these objects while still following the rules for Matrix operations.

In my implementation every image is a Matrix<RGBElement> and RGBElement is a matrix of integers defined as Matrix<IntegerElement>. 

We keep the Matrix operation for the overall image but we can define a new operation for the Matrix within the RGBElement class. For example: when doing addition we do not want a value to go over 255; we are able to define that behavior within the RGBElement without having to change the implementation of Matrix.


| Operation |Image 1| Image 2 | Result|
|-------|------|---------|-------|
|Add|![Cat](/resources/cat.jpg) |![Arch](/resources/arch.jpg) | ![Add](/resources/addCatArch.jpg)
|Subtract|![Flower](/resources/little_girl_in_forest.jpg) |![Moon](/resources/moon-landing.jpg) | ![Sub](/resources/subFlowerMoon.jpg)
|Multiply|![Cat](/resources/cat.jpg) |![Arch](/resources/arch.jpg) | ![Mul](/resources/mulCatArch.jpg)
