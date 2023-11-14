package co.comingle.android.model

import java.time.Instant

data class NostrCalendarEvent(
  val authorHexPubkey: String,
  val primaryRelay: String,
  val uuid: String,
  val summary: String,
  val start: Instant,
  val end: Instant?,
  val location: String?,
  val geohash: String?,
  val participants: List<Participant>,
  val hashtags: List<String>,
  val references: List<String>
)

data class Participant(
  val hexPubkey: String,
  val relay: String?,
  val role: String
)
