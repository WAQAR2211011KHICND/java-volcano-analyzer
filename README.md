## Author : Muhammad Waqar & Anoosha Rasheed
# Java Streams with Volcanoes

## Objectives

* Use higher-order functions to manipulate data about historical volcanic eruptions

## Instructions

Write your code in `VolcanoAnalyzer.java`.

`volcano.json` contains a data set of 804 historical volcanic eruptions.  Below is a sample of the data for each eruption.

```JSON
  {
    "year": 1362,
    "tsu": "",
    "eq": "",
    "name": "Oraefajokull",
    "location": "Iceland-SE",
    "country": "Iceland",
    "latitude": 64,
    "longitude": -16.65,
    "elevation": 2119,
    "type": "Stratovolcano",
    "vei": 5,
    "agent": "T,F",
    "deaths": "220"
  }
```

Use java streams and any other higher-order functions to analyze the data in the following ways:

1. Return the volcanoes that erupted in the 1980s.
2. Return an array of the names of volcanoes that had an eruption with a Volcanic Explosivity Index (VEI) of 6 or higher.
3. Return the eruption with the highest number of recorded deaths.
4. Return the percentage of eruptions that caused tsunamis.
5. Return the most common type of volcano in the set.
6. Return the number of eruptions when supplied a country as an argument.
7. Return the average elevation of all eruptions.
8. Return an array of types of volcanoes.
9. Return the percentage of eruptions that occurred in the Northern Hemisphere.
10. Return the names of eruptions that occurred after 1800, that did NOT cause a tsunami, happened in the Southern Hemisphere, and had a VEI of 5.
11. Return the names of eruptions that occurred at or above an elevation passed in as an argument.
12. Return the agents of death for the ten most deadly eruptions.

Key for Agents of Death:
![Key for Agents of Death](./agents.png)

### References

Volcano data retrieved from: National Geophysical Data Center / World Data Service (NGDC/WDS): Significant Volcanic Eruptions Database. National Geophysical Data Center, NOAA. [doi:10.7289/V5JW8BSH](https://data.nodc.noaa.gov/cgi-bin/iso?id=gov.noaa.ngdc.mgg.hazards:G10147)

