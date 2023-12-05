### Hexlet tests and linter status:
[![Actions Status](https://github.com/MarieTask/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/MarieTask/java-project-78/actions)
[![Java CI](https://github.com/MarieTask/java-project-78/actions/workflows/main.yaml/badge.svg)](https://github.com/MarieTask/java-project-78/actions/workflows/main.yaml)
[![Maintainability](https://api.codeclimate.com/v1/badges/8d0c0a3739dd50fdbfcc/maintainability)](https://codeclimate.com/github/MarieTask/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/8d0c0a3739dd50fdbfcc/test_coverage)](https://codeclimate.com/github/MarieTask/java-project-78/test_coverage)

## Idea:
Data validator is a library that can be used to check the correctness of any data. Every language has many similar libraries, almost all programs work with external data that must be checked for correctness. First of all, we are talking about user-generated data. The yup library was taken as the basis for the project.

# Description:
This application implements the ability to check data of several types: strings, numbers, objects of the map-type, as well as to check complex (nested) data based on map collections.

String data type checks: matching a string, null, empty string, finding a substring in a given string and matching the minimum specified string length.

Integers data type checks: notnull value check, checking for compliance with a positive number (not including zero) and occurrence in the specified range check.

Map data type checks: checking for not null, for compliance of the map with the specified size, ad also checking the values by the map keys for compliance with the validation scheme transmitted by the user (nested data validation realized for map collections).