# Add notes: #

Syntax: **`+ <currency value number>`**

_`<currency>`_ is 3 uppercase letters, any combination is valid

_`<value>`_ is the value of notes. Valid values are 10n and 5\*10n, 0<=n<=3

_`<number>`_ is any positive integer

Semantics: puts notes into cash

Reply: OK if successful, ERROR if validation fails

Example:

> _+ USD 100 30_

OK



# Get cash: #

Syntax: **`- <currency> <amount>`**

_`<currency>`_ as described above,

_`<amount>`_ any positive integer

Semantics: get the sum from the cash if possible.

Reply: one line per each note value, formatted as

_`<value> <number of notes>`_, followed with a line OK

ERROR if the amount is unavailable (cash remains unchanged).

Example:

> _- USD 2000_

> _100 20_

> _OK_



# Print cash: #

Syntax: **?**

Reply: one line for each currency/value pair

_`<currency> <value> <number>`_

followed by the line OK

Semantics: what is currently in the cash

Example: see in [SampleSession](SampleSession.md)