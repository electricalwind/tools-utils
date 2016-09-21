[lu.jimenez.research.tools.utils](../index.md) / [Serialization](.)

# Serialization

`object Serialization`

Serialization Utilitary object

this object contains several functions that allow to serialize/ Deserialize a list of Serializable Object

### Functions

| Name | Summary |
|---|---|
| [loadListData](load-list-data.md) | `fun loadListData(path: String): List<Any>?`<br>Loading the data save in an object file
Reverse of saveListData |
| [loadMapData](load-map-data.md) | `fun loadMapData(path: String): Map<`[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)`, `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)`>?`<br>Loading the data save in an object file
Reverse of saveMapStringData |
| [loadMapHashData](load-map-hash-data.md) | `fun loadMapHashData(path: String): Map<Int, Any>?`<br>Loading the data save in an object file
Reverse of saveMapHashData |
| [loadMapStringData](load-map-string-data.md) | `fun loadMapStringData(path: String): Map<String, Any>?`<br>Loading the data save in an object file
Reverse of saveMapStringData |
| [saveListData](save-list-data.md) | `fun saveListData(listFile: List<Any>, path: String): Unit`<br>Saving to an object file the array List of Serializable object |
| [saveMapData](save-map-data.md) | `fun saveMapData(mapStringObject: Map<`[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)`, `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)`>, path: String): Unit`<br>Saving to an object file a map of string object |
| [saveMapHashData](save-map-hash-data.md) | `fun saveMapHashData(mapHashObject: Map<Int, Any>, path: String): Unit`<br>Saving to an object file the map of objects |
| [saveMapStringData](save-map-string-data.md) | `fun saveMapStringData(mapStringObject: Map<String, Any>, path: String): Unit`<br>Saving to an object file a map of string object |
