import kotlinx.cinterop.*
import raylib.*


@OptIn(ExperimentalForeignApi::class)
fun color(r: UByte, g: UByte, b: UByte, a: UByte): CValue<Color> =
    nativeHeap.alloc<Color> {
        this.r = r
        this.g = g
        this.b = b
        this.a = a
    }.readValue()

@OptIn(ExperimentalForeignApi::class)
fun main() {

    val screenWidth = 800;
    val screenHeight = 450;

    InitWindow(screenWidth, screenHeight, "Raylib + Kotlin/Native")

    val white = color(245u, 245u, 245u, 255u)        // RAYWHITE
    val lightGray = color(200u, 200u, 200u, 255u)    // LIGHTGRAY

    while (!WindowShouldClose()) {
        BeginDrawing()
        ClearBackground(white)
        DrawText("Hello from Raylib + Kotlin/Native!", 190, 200, 20, lightGray)
        EndDrawing()
    }

    CloseWindow()
}
