package scs_sdk.model.events.job

/**
 * Sealed class to handle different job events
 *
 * @author Felipe Gonzalez
 *
 */
sealed class EventsJobType {

    /**
     * Job type event related to delivered cargo
     *
     * @author Felipe Gonzalez
     *
     * @property timeTaken
     * @property startedTimeStamp
     * @property deliveredTimeStamp
     * @property earnedXP
     * @property cargoDamage
     * @property distance traveled
     * @property autoParked if player select autoParked
     * @property revenue earned from job
     * @property active [True|False] if event is still active
     */
    data class EventsJobDelivered(
        val timeTaken: Int,
        val startedTimeStamp: Int,
        val deliveredTimeStamp: Int,
        val earnedXP: Int,
        val cargoDamage: Float,
        val distance: Int,
        val autoParked: Boolean,
        val revenue: Long,
        val active: Boolean
    ) : EventsJobType()

    /**
     * Job type event related to started cargo
     *
     * @author Felipe Gonzalez
     *
     * @property autoLoaded if player select autoload cargo
     * @property active [True|False] if event is still active
     */
    data class EventsJobStarted(
        val autoLoaded: Boolean,
        val active: Boolean
    ) : EventsJobType()

    /**
     * Job type event related to cancelled Job
     *
     * @author Felipe Gonzalez
     *
     * @property penalty received for cancel
     * @property startedTimeStamp
     * @property cancelledTimestamp
     * @property active [True|False] if event is still active
     */
    data class EventsJobCancelled(
        val penalty: Long,
        val startedTimeStamp: Int,
        val cancelledTimestamp: Int,
        val active: Boolean
    ) : EventsJobType()

    /**
     * Job type event related to finished Job
     *
     * @author Felipe Gonzalez
     * @property active [True|False] if event is still active
     */
    data class EventsJobFinished(
        val active: Boolean
    ) : EventsJobType()
}