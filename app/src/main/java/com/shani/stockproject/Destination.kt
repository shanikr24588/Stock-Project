package com.shani.stockproject

interface Destination {
    var route:String
}

object HomeScreen:Destination{
    override var route: String ="HomeScreen"
}
object SearchScreen:Destination{
    override var route: String = "SearchScreen"

}