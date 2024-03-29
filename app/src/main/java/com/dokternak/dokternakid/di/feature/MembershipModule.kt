package com.dokternak.dokternakid.di.feature

import com.dokternak.dokternakid.data.membership.MembershipDatastore
import com.dokternak.dokternakid.data.membership.MembershipRepository
import com.dokternak.dokternakid.domain.membership.MembershipInteractor
import com.dokternak.dokternakid.domain.membership.MembershipUseCase
import org.koin.dsl.module

val membershipModule = module {

    factory<MembershipUseCase> { MembershipInteractor(get()) }
    factory<MembershipRepository> { MembershipDatastore(get(), get()) }

    single { MembershipDatastore(get(), get()) }
    single { MembershipInteractor(get()) }

}