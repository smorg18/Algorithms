	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 12
	.globl	_fcn0
	.p2align	4, 0x90
_fcn0:                                  ## @fcn0
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp0:
	.cfi_def_cfa_offset 16
Ltmp1:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp2:
	.cfi_def_cfa_register %rbp
                                        ## kill: %ESI<def> %ESI<kill> %RSI<def>
                                        ## kill: %EDI<def> %EDI<kill> %RDI<def>
	leal	(%rdi,%rsi,2), %eax
	addl	%eax, %eax
	popq	%rbp
	retq
	.cfi_endproc

	.globl	_main
	.p2align	4, 0x90
_main:                                  ## @main
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp3:
	.cfi_def_cfa_offset 16
Ltmp4:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp5:
	.cfi_def_cfa_register %rbp
	movl	$2, %edi
	movl	$3, %esi
	popq	%rbp
	jmp	_fcn0                   ## TAILCALL
	.cfi_endproc


.subsections_via_symbols
