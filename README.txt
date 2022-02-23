# NBA-Shooting

I wanted to determine if taking 3 point shots in basketball is more efficient (higher expected return) than mid-range shots

Found dataset of all NBA shots taken during the 2014-2015 season on Kaggle.com 
  Cleaned dataset to only contain information about the shot result (make/miss) and the shot distance from the basket

Used NYU's cluster computer to process data
  Used Apache's Hadoop software to process dataset
  Used MapReduce
    Split dataset into 3 determined shot distances (>13 feet, 14 - 22 feet, 22< feet)
      For each distance, Mapper made 2 new keys (one key tracking every shot, and one key tracking only the made shots)
      For each distance, Reducer counted the total number of shots and total number of made shots
        Found shot percentage from each distance
        Multiplied shot percentage from each distance by their respective point values to determine the expected value of shots from each range
        
Challenges
  Cleaning csv data when some cells contain commas --> splitting by commas led to extra unwanted keys
  Skipping first row of dataset (first row only contained the row titles not any actual information)
  
