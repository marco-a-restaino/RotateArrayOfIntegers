public class RotateArrayOfIntegers {

	public void rotateArray(int[] integerArray, int rotationAmount) {

		//If rotation amount is <= 0 or array length is <= 1 we do nothing and exit the method
		if (rotationAmount <= 0 || integerArray.length <= 1) {
			return;
		}

		//Mod the rotation amount based on the size of the array to scale values larger than the array's size
		rotationAmount = rotationAmount % integerArray.length;

		int counter = 0;

		for (int index = 0; counter < integerArray.length; index++) {
			
			//Set the initial source value that is moving
			int sourceValue = integerArray[index];
			
			//Set the initial index
			int currentIndex = index;

			do {
				
				//Set the index we are moving the value at integerArray[currentIndex] to based on the rotationAmount
				int targetIndex = (currentIndex - rotationAmount) >= 0 ? (currentIndex - rotationAmount)
						: ((integerArray.length) + (currentIndex - rotationAmount));

				//Save the value being replaced at the index we are moving to
				int targetValue = integerArray[targetIndex];

				//Set the target index to our source value that is being moved
				integerArray[targetIndex] = sourceValue;

				//Set our new value to be moved to the value we just replaced
				sourceValue = targetValue;

				//Our next index to swap is where we just moved a new value to
				currentIndex = targetIndex;

				counter++;

			} while (index != currentIndex); //We are done in one full pass once all values have been moved to their correct position
		}
	}
}