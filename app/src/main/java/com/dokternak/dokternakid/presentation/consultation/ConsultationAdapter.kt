package com.dokternak.dokternakid.presentation.consultation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dokternak.dokternakid.databinding.ItemConsultationBinding
import com.dokternak.dokternakid.domain.article.consultation.model.Consultation
import com.dokternak.dokternakid.utils.ConstVal.OFFICER_IMAGE_BASE_URL
import com.dokternak.dokternakid.utils.ext.setImageUrl

class ConsultationAdapter : RecyclerView.Adapter<ConsultationAdapter.ConsultationViewHolder>() {

    private val consultationList = mutableListOf<Consultation>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Consultation>) {
        consultationList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ConsultationAdapter.ConsultationViewHolder {
        val binding =
            ItemConsultationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConsultationViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ConsultationAdapter.ConsultationViewHolder,
        position: Int
    ) {
        consultationList[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = consultationList.size

    inner class ConsultationViewHolder(private val binding: ItemConsultationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(consultation: Consultation) {
            binding.apply {
                imgDoctor.setImageUrl(OFFICER_IMAGE_BASE_URL + consultation.photo)
                tvDoctorName.text = consultation.doctorName
                tvComplaint.text = consultation.complaint
                tvDate.text = consultation.date
            }
        }
    }

}