package com.example.note2.Data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.note2.Model.Note


class NoteDataSource{
    fun loadNotes():List<Note>{
        return listOf(
            Note(title ="A Good Day" , description ="We went of vacation"),
            Note(title ="Kelsey Ables" , description ="Some cultures see the moon as linked to death, Weibel noted. " ),
            Note(title =" Nick Alvarez" , description ="It should be noted that these are takeaways from UA’s third practice and the team wasn’t in full pads." ),
            Note(title ="Greg Wehner" , description ="The suspect is believed to have been in the Bel Air area for days leading up to the crime, the sheriff’s office" ),
            Note(title ="Brent Lang" , description ="Outbreaks of the flu and a cold front across much of the country may have depressed ticket sales." ),
            Note(title =" Richard Brody" , description ="the lawsuit notes, occurred even after a student was stabbed at the school three weeks prior" )
        )
    }
}