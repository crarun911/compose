package com.dcoders.playground.play



sealed class Video(){
    data class Programming(val title: String,val duration: String): Video()
    data class Cooking(val title: String,val duration: String): Video()
    data class Travel(val title: String,val duration: String): Video()
}


inline fun <reified T>  filterList(videos: List<Video>): List<T>{
    return videos.filterIsInstance<T>()
}
inline fun transformation(list: List<Video>,
                          noinline tranformation:(Video)-> Video,
                          crossinline onComplete:(List<Video>)->Unit){
    val transoformList=list.map(tranformation)
    return onComplete(transoformList)
}
fun main(){

    val videos=listOf<Video>(
        Video.Programming("Programming java","1day"),
        Video.Programming("Programming kotlin","1day"),
        Video.Cooking("Cooking","2 days"),
        Video.Travel("Travelling","3 days")
    )
    val filteredList=filterList<Video.Cooking>(videos)
    print(filteredList)
    transformation(videos, tranformation = {it->
        when(it){
            is Video.Cooking -> it.copy(it.title.plus("transform"))
            is Video.Programming ->  it.copy(it.title.plus("transform"))
            is Video.Travel ->  it.copy(it.title.plus("transform"))
        }
    }, onComplete ={
        it.forEach {
            println(it)
        }
    } )
}