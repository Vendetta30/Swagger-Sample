package com.nexthoughts

class City {
    Date dateCreated
    Date lastUpdated
    String cityName
    String postalCode
    String countryCode
    static constraints = {
        postalCode blank: false, nullable: false
        cityName blank: false, nullable: false
        countryCode minSize: 2, maxSize: 3, blank: false, nullable: false, matches: "[A-Z]+"
    }
}
