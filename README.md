# Booze Calculator

A simple Android app for calculating the total number of (Canadian) standard drinks based on user input for volume, alcohol percentage, and count of beverages.

## Features
- Dynamically updates the total number of standard drinks.
- Handles multiple input fields for different drink entries.
- Easy-to-use interface with volume, percentage, and count inputs for each drink.

## How It Works
1. Input the volume (in milliliters), alcohol percentage (as a number), and count of drinks in the respective fields.
2. The app dynamically calculates the total standard drinks using the formula:
totalStandardDrinks += ((volume * count * (percent / 100)) / 17.05).
3. The result is displayed in the result field.
