# PredictingUsersInterest
## Machine Learning with Java

In this project , I made use of the Naive Bayesian Classifier which classifies a users or say predicts the interest list of the user depending on the parameters such as age,gender,profession.

## Need for Implementing
Can be used for getting to know the users interest in cases such as a user logging in on a news application for the first time which would help 
to show the specific news depending on the user's interest  from the prediction made on the user

### Example

| AGE           | GENDER        | PROFESSION    | LIST          |
| ------------- | ------------- | ------------- | ------------- |
| 21            | male          | it            | list1         |
| 45            | female        | business      | list4         |

Above is just a sample set from training dataset showing all the parameters
I also generated a reat api which takes the json 
```
{
  "age": 23,
  "gender": "male",
  "profession": "it"
}
```
and then return me the predicted interest topics list of the user
For the above json the result will be 
```
[
  {
    "topic": "technology",
    "imageurl": "/"
  },
  {
    "topic": "music",
    "imageurl": "/"
  },
  {
    "topic": "business",
    "imageurl": "/"
  },
  {
    "topic": "business",
    "imageurl": "/"
  },
  {
    "topic": "food",
    "imageurl": "/"
  }
]
```
## Built With

* Spring Boot
* Maven
* Weka-Weka is a collection of machine learning algorithms for data mining tasks. It contains tools for data preparation, classification, regression, clustering, association rules mining, and visualization. 





