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

// 1920 x 1080
const val WIDTH_SIZE = 800;
const val HEIGHT_SIZE = 450;

@OptIn(ExperimentalForeignApi::class)
fun main() {

    // Initialization
    InitWindow(
        width = WIDTH_SIZE,
        height = HEIGHT_SIZE,
        title = "Raylib + Kotlin/Native"
    )

    val RAYWHITE = color(245u, 245u, 245u, 255u)
    val LIGHTGRAY = color(200u, 200u, 200u, 255u)

    while (!WindowShouldClose()) {
        BeginDrawing()
        ClearBackground(RAYWHITE)
        DrawText("Hello from Raylib + Kotlin/Native!", 190, 200, 20, LIGHTGRAY)
        EndDrawing()
    }

    CloseWindow()
}
