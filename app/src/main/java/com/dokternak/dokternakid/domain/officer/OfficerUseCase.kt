package com.dokternak.dokternakid.domain.officer

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.officer.model.Officer
import kotlinx.coroutines.flow.Flow

interface OfficerUseCase {

    fun getAllOfficers(): Flow<ApiResponse<List<Officer>>>

    fun getOfficerDetail(id: String): Flow<ApiResponse<Officer>>

    fun getSearchOfficers(officerName: String): Flow<ApiResponse<List<Officer>>>

}