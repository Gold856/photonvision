###############################################################################
## Copyright (C) Photon Vision.
###############################################################################
## This program is free software: you can redistribute it and/or modify
## it under the terms of the GNU General Public License as published by
## the Free Software Foundation, either version 3 of the License, or
## (at your option) any later version.
##
## This program is distributed in the hope that it will be useful,
## but WITHOUT ANY WARRANTY; without even the implied warranty of
## MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
## GNU General Public License for more details.
##
## You should have received a copy of the GNU General Public License
## along with this program.  If not, see <https://www.gnu.org/licenses/>.
###############################################################################

###############################################################################
## THIS FILE WAS AUTO-GENERATED BY ./photon-serde/generate_messages.py.
##                        --> DO NOT MODIFY <--
###############################################################################

from ..targeting import *
from ..packet import Packet


class PnpResultSerde:
    # Message definition md5sum. See photon_packet.adoc for details
    MESSAGE_VERSION = "ae4d655c0a3104d88df4f5db144c1e86"
    MESSAGE_FORMAT = "Transform3d best;Transform3d alt;float64 bestReprojErr;float64 altReprojErr;float64 ambiguity;"

    @staticmethod
    def pack(value: "PnpResult") -> "Packet":
        ret = Packet()

        ret.encodeTransform(value.best)

        ret.encodeTransform(value.alt)

        # bestReprojErr is of intrinsic type float64
        ret.encodeDouble(value.bestReprojErr)

        # altReprojErr is of intrinsic type float64
        ret.encodeDouble(value.altReprojErr)

        # ambiguity is of intrinsic type float64
        ret.encodeDouble(value.ambiguity)
        return ret

    @staticmethod
    def unpack(packet: "Packet") -> "PnpResult":
        ret = PnpResult()

        ret.best = packet.decodeTransform()

        ret.alt = packet.decodeTransform()

        # bestReprojErr is of intrinsic type float64
        ret.bestReprojErr = packet.decodeDouble()

        # altReprojErr is of intrinsic type float64
        ret.altReprojErr = packet.decodeDouble()

        # ambiguity is of intrinsic type float64
        ret.ambiguity = packet.decodeDouble()

        return ret


# Hack ourselves into the base class
PnpResult.photonStruct = PnpResultSerde()
