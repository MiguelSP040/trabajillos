package mx.edu.p2_intent

import android.app.*
import android.os.*
import android.widget.*
import android.view.View
import androidx.appcompat.app.AppCompatActivity

// Definición de la clase P3TareaActivity que extiende AppCompatActivity,
// lo que significa que es una actividad de Android.
class P3TareaActivity : AppCompatActivity() {
    // Declaración de variables para los componentes de la interfaz.
    // Se usa 'lateinit' para inicializarlas más tarde.
    private lateinit var progressBar: ProgressBar
    private lateinit var seekBar: SeekBar
    private lateinit var ratingBar: RatingBar
    private lateinit var textViewPriority: TextView
    private lateinit var textViewDate: TextView
    private lateinit var textViewTime: TextView

    // Variables para almacenar la fecha y la hora seleccionadas.
    private var selectedDate = ""
    private var selectedTime = ""
    //Métodod 'onCreate' que se ejecuta cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        //Llama al método del padre para inicializar la actividad
        super.onCreate(savedInstanceState)
        //Asocia la interfaz gráfica con el archivo XML 'activity_p3_tarea'
        setContentView(R.layout.activity_p3_tarea)
        // Inicialización de los elementos de la interfaz a través de sus IDs.
        progressBar = findViewById(R.id.progressBar)
        seekBar = findViewById(R.id.seekBar)
        ratingBar = findViewById(R.id.ratingBar)
        textViewPriority = findViewById(R.id.textViewPriority)
        textViewDate = findViewById(R.id.textViewDate)
        textViewTime = findViewById(R.id.textViewTime)
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val buttonDatePicker = findViewById<Button>(R.id.buttonDatePicker)
        val buttonTimePicker = findViewById<Button>(R.id.buttonTimePicker)

        // Inicialmente, el ProgressBar se oculta para que no sea visible
        // hasta que se inicie la acción de guardar.
        progressBar.visibility = View.INVISIBLE

        // Configuración del 'SeekBar' para ajustar
        // la prioridad
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            //Método que se ejecuta cuando cambia el progreso del 'SeekBar'
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //Actualiza el 'TextView' para mostrar el valor de la prioridad seleccionada
                textViewPriority.text = "Prioridad: $progress"
            }
            //Métodos vacíos para cuando se empieza y se detiene el movimiento deñ 'SeekBar'
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        //Configuración del botón para abrir el DatePickerDialog
        buttonDatePicker.setOnClickListener {
            //Muestra un diálogo para seleccionar una fecha
            //Al seleccionar la fecha, actualiza la variable y el 'TextView'
            val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
                selectedDate = "$dayOfMonth/$month/$year"
                textViewDate.text = "Fecha: $selectedDate"
            }, 2024, 1, 12)
            datePickerDialog.show()
        }

        //Configuración del botón para abrir el TimePickerDialog
        buttonTimePicker.setOnClickListener {
            //Muestra un diálogo para seleccionar una hora
            //Al seleccionar la hora, actualiza la variable y el 'TextView'
            val timePickerDialog = TimePickerDialog(this, { _, hourOfDay, minute ->
                selectedTime = "$hourOfDay:$minute"
                textViewTime.text = "Hora: $selectedTime"
            }, 12, 0, true)
            timePickerDialog.show()
        }

        buttonSave.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.INVISIBLE
                Toast.makeText(this, "Tarea guardada", Toast.LENGTH_SHORT).show()
            }, 3000)
        }

        ratingBar.setOnRatingBarChangeListener{ _, rating, _ ->
            Toast.makeText(this, "Calificación: $rating estrellas", Toast.LENGTH_SHORT).show()
        }


    }
}