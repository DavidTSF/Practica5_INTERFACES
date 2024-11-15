package dev.davidvega.elsol

class Planeta() {
    var nombre = ""
    var imageViewId: Int = 0

    var diametro = 0.0
    var distanciaSol = 0.0
    var densidad = 0

    constructor(nombre: String, image: Int) : this() {
        this.nombre = nombre
        this.imageViewId = image
    }

    constructor(nombre: String, diametro: Double?, distanciaSol:Double, densidad: Int) : this() {
        this.nombre = nombre
        if (diametro != null) {
            this.diametro = diametro
        }
        this.distanciaSol = distanciaSol
        this.densidad = densidad
    }

    override fun toString(): String {
        return nombre
    }


}