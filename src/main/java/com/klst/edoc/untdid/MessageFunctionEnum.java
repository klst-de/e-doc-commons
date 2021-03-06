package com.klst.edoc.untdid;

import java.util.HashMap;
import java.util.Map;

/* 
 * United Nations Trade Data Interchange Directory (UNTDID), http://www.unece.org/fileadmin/DAM/trade/untdid/d16b/tred/tredi2.htm
 * UN/EDIFACT 1225  Message function code

	Code indicating the function of the message.  

     1     Cancellation
              Message cancelling a previous transmission for a given
              transaction.

     2     Addition
              Message containing items to be added.

     3     Deletion
              Message containing items to be deleted.

     4     Change
              Message containing items to be changed.

     5     Replace
              Message replacing a previous message.

     6     Confirmation
              Message confirming the details of a previous
              transmission where such confirmation is required or
              recommended under the terms of a trading partner
              agreement.

     7     Duplicate
              The message is a duplicate of a previously generated
              message.

     8     Status
              Code indicating that the referenced message is a status.

     9     Original
              Initial transmission related to a given transaction.

     10    Not found
              Message whose reference number is not filed.

     11    Response
              Message responding to a previous message or document.

     12    Not processed
              Message indicating that the referenced message was
              received but not yet processed.

     13    Request
              Code indicating that the referenced message is a
              request.

     14    Advance notification
              Code indicating that the information contained in the
              message is an advance notification of information to
              follow.

     15    Reminder
              Repeated message transmission for reminding purposes.

     16    Proposal
              Message content is a proposal.

     17    Cancel, to be reissued
              Referenced transaction cancelled, reissued message will
              follow.

     18    Reissue
              New issue of a previous message (maybe cancelled).

     19    Seller initiated change
              Change information submitted by buyer but initiated by
              seller.

     20    Replace heading section only
              Message to replace the heading of a previous message.

     21    Replace item detail and summary only
              Message to replace item detail and summary of a previous
              message.

     22    Final transmission
              Final message in a related series of messages together
              making up a commercial, administrative or transport
              transaction.

     23    Transaction on hold
              Message not to be processed until further release
              information.

     24    Delivery instruction
              Delivery schedule message only used to transmit short-
              term delivery instructions.

     25    Forecast
              Delivery schedule message only used to transmit long-
              term schedule information.

     26    Delivery instruction and forecast
              Combination of codes '24' and '25'.

     27    Not accepted
              Message to inform that the referenced message is not
              accepted by the recipient.

     28    Accepted, with amendment in heading section
              Message accepted but amended in heading section.

     29    Accepted without amendment
              Referenced message is entirely accepted.

     30    Accepted, with amendment in detail section
              Referenced message is accepted but amended in detail
              section.

     31    Copy
              Indicates that the message is a copy of an original
              message that has been sent, e.g. for action or
              information.

     32    Approval
              A message releasing an existing referenced message for
              action to the receiver.

     33    Change in heading section
              Message changing the referenced message heading section.

     34    Accepted with amendment
              The referenced message is accepted but amended.

     35    Retransmission
              Change-free transmission of a message previously sent.

     36    Change in detail section
              Message changing referenced detail section.

     37    Reversal of a debit
              Reversal of a previously posted debit.

     38    Reversal of a credit
              Reversal of a previously posted credit.

     39    Reversal for cancellation
              Code indicating that the referenced message is reversing
              a cancellation of a previous transmission for a given
              transaction.

     40    Request for deletion
              The message is given to inform the recipient to delete
              the referenced transaction.

     41    Finishing/closing order
              Last of series of call-offs.

     42    Confirmation via specific means
              Message confirming a transaction previously agreed via
              other means (e.g. phone).

     43    Additional transmission
              Message already transmitted via another communication
              channel. This transmission is to provide electronically
              processable data only.

     44    Accepted without reserves
              Message accepted without reserves.

     45    Accepted with reserves
              Message accepted with reserves.

     46    Provisional
              Message content is provisional.

     47    Definitive
              Message content is definitive.

     48    Accepted, contents rejected
              Message to inform that the previous message is received,
              but it cannot be processed due to regulations, laws,
              etc.

     49    Settled dispute
              The reported dispute is settled.

     50    Withdraw
              Message withdrawing a previously approved message.

     51    Authorisation
              Message authorising a message or transaction(s).

     52    Proposed amendment
              A code used to indicate an amendment suggested by the
              sender.

     53    Test
              Code indicating the message is to be considered as a
              test.

     54    Extract
              A subset of the original.

     55    Notification only
              The receiver may use the notification information for
              analysis only.

     56    Advice of ledger booked items
              An advice that items have been booked in the ledger.

     57    Advice of items pending to be booked in the ledger
              An advice that items are pending to be booked in the
              ledger.

     58    Pre-advice of items requiring further information
              A pre-advice that items require further information.

     59    Pre-adviced items
              A pre-advice of items.

     60    No action since last message
              Code indicating the fact that no action has taken place
              since the last message.

     61    Complete schedule
              The message function is a complete schedule.

     62    Update schedule
              The message function is an update to a schedule.

     63    Not accepted, provisional
              Not accepted, subject to confirmation.

     64    Verification
              The message is transmitted to verify information.

     65    Unsettled dispute
              To report an unsettled dispute.

     66    Discharge of operation guarantee
              A message related to a guarantee containing information
              about the discharge of an operation.

     67    Termination of operation guarantee
              A message related to a guarantee containing information
              about the termination of an operation.

     68    Start of operation guarantee
              A message related to a guarantee containing information
              about the start of an operation.

     69    Advanced cargo information
              A message related to a guarantee containing advanced
              cargo information.

 */
public enum MessageFunctionEnum {

	Cancellation 	(1),
	Addition 		(2),
	Deletion 		(3),
	Change 			(4),
	Replace 		(5),
	Confirmation 	(6),
	Duplicate 		(7),
	Original 		(9),
	Status			(8),
	// ...
	Retransmission (35);
	
	/**
	 * @see <A HREF="http://www.unece.org/trade/untdid/d13b/tred/tred1225.htm">UN/EDIFACT 1225</A>
	 */
	public static final String SCHEME_ID  = "UN/EDIFACT 1225";

	MessageFunctionEnum(int value) {
		this.value = value;
	}
	
	private final int value;
	
	int getValue() {
		return value;
	}

	public String getValueAsString() {
		return ""+value;
	}

    private static Map<Integer, MessageFunctionEnum> map = new HashMap<Integer, MessageFunctionEnum>();
    static {
        for (MessageFunctionEnum documentNameCode : MessageFunctionEnum.values()) {
            map.put(documentNameCode.value, documentNameCode);
        }
    }
    
    public static MessageFunctionEnum valueOf(int code) {
        return map.get(code);
    }

}
