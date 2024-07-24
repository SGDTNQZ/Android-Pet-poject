//package com.littlelemon.petproject.viewModels
//
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//
//class WorkoutViewModel(viewModel: WorkoutViewModel?) {
//    private val _exerciseName = MutableStateFlow("")
//    val exerciseName: StateFlow<String> get() = _exerciseName
//
//    private val _exerciseWeight = MutableStateFlow("")
//    val exerciseWeight: StateFlow<String> get() = _exerciseWeight
//
//    private val _exerciseReps = MutableStateFlow("")
//    val exerciseReps: StateFlow<String> get() = _exerciseReps
//
//    private var exerciseSetNumber: MutableList<Int> = mutableListOf()
//
////    private val _exerciseReps = MutableStateFlow("")
////    val exerciseReps: StateFlow<String> get() = _exerciseReps
//
//    fun updateExerciseName(name:String){
//        _exerciseName.value = name
//    }
//
//    fun updateExerciseWeight(weight: String){
//        _exerciseWeight.value = weight
//    }
//
//    fun updateExerciseReps(reps: String){
//        _exerciseReps.value = reps
//    }
////
////    fun addExerciseSet(set: Int){
////        exerciseSetNumber.add(set)
////    }
//}