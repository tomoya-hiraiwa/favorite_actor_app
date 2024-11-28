package tomoya.app.favorite_actor_app

data class ActorData(
    var name: String = "",
    var gender: String = "",
    var age: String = "",
    var imagePath: String = "",
    var category: String = ""
)


val demoActorData = listOf(
    ActorData("Jane Dow","Women","20","","none"),
    ActorData("Jane Dow","Women","20","","none"),
    ActorData("Jane Dow","Women","20","","none"),
    ActorData("Jane Dow","Women","20","","none"),
)