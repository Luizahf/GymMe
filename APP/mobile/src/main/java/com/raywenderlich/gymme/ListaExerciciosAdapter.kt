/*
 * Copyright (c) 2017 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.gymme

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.adapter_exercicio.view.*

class ListaExerciciosAdapter(
        private val exercicios: MutableList<Exercicio>,
        private val callback: Callback?
) : RecyclerView.Adapter<ListaExerciciosAdapter.ExercicioViewHolder>() {

  override fun onBindViewHolder(holder: ExercicioViewHolder, position: Int) {
    val exercicio = exercicios[position]
    holder.itemView.title.text = exercicio.titulo
    holder.itemView.valorCarga.text = exercicio.carga.toString()
    holder.itemView.valorSeries.text = exercicio.series.toString()
    holder.itemView.valorRepeticoes.text = exercicio.repeticoes.toString()
    holder.itemView.setOnClickListener {
      callback?.clicouExercicio(exercicio)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercicioViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_exercicio, parent, false)
    return ExercicioViewHolder(view)
  }

  override fun getItemCount() = exercicios.size

  fun atualizarExercicio(exercicio: Exercicio) {
    for ((index, value) in exercicios.withIndex()) {
      if (value.titulo == exercicio.titulo) {
        exercicios[index] = exercicio
      }
    }

    notifyDataSetChanged()
  }

  inner class ExercicioViewHolder(view: View) : RecyclerView.ViewHolder(view)

  interface Callback {
    fun clicouExercicio(exercicio: Exercicio)
  }
}