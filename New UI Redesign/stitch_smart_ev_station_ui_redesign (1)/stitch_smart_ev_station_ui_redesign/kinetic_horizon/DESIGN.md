---
name: Kinetic Horizon
colors:
  surface: '#faf8ff'
  surface-dim: '#d2d9f4'
  surface-bright: '#faf8ff'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#f2f3ff'
  surface-container: '#eaedff'
  surface-container-high: '#e2e7ff'
  surface-container-highest: '#dae2fd'
  on-surface: '#131b2e'
  on-surface-variant: '#3f4850'
  inverse-surface: '#283044'
  inverse-on-surface: '#eef0ff'
  outline: '#707881'
  outline-variant: '#bfc7d2'
  surface-tint: '#006398'
  primary: '#006194'
  on-primary: '#ffffff'
  primary-container: '#007bb9'
  on-primary-container: '#fdfcff'
  inverse-primary: '#93ccff'
  secondary: '#006c49'
  on-secondary: '#ffffff'
  secondary-container: '#6cf8bb'
  on-secondary-container: '#00714d'
  tertiary: '#b61722'
  on-tertiary: '#ffffff'
  tertiary-container: '#da3437'
  on-tertiary-container: '#fffbff'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#cce5ff'
  primary-fixed-dim: '#93ccff'
  on-primary-fixed: '#001d31'
  on-primary-fixed-variant: '#004b73'
  secondary-fixed: '#6ffbbe'
  secondary-fixed-dim: '#4edea3'
  on-secondary-fixed: '#002113'
  on-secondary-fixed-variant: '#005236'
  tertiary-fixed: '#ffdad7'
  tertiary-fixed-dim: '#ffb3ad'
  on-tertiary-fixed: '#410004'
  on-tertiary-fixed-variant: '#930013'
  background: '#faf8ff'
  on-background: '#131b2e'
  surface-variant: '#dae2fd'
typography:
  display-lg:
    fontFamily: Space Grotesk
    fontSize: 56px
    fontWeight: '700'
    lineHeight: 64px
    letterSpacing: -0.03em
  display-lg-mobile:
    fontFamily: Space Grotesk
    fontSize: 38px
    fontWeight: '700'
    lineHeight: 44px
    letterSpacing: -0.02em
  display-md:
    fontFamily: Space Grotesk
    fontSize: 40px
    fontWeight: '600'
    lineHeight: 48px
    letterSpacing: -0.02em
  display-md-mobile:
    fontFamily: Space Grotesk
    fontSize: 30px
    fontWeight: '600'
    lineHeight: 36px
    letterSpacing: -0.02em
  telemetry-metric:
    fontFamily: Space Grotesk
    fontSize: 48px
    fontWeight: '700'
    lineHeight: 52px
    letterSpacing: -0.04em
  telemetry-metric-sm:
    fontFamily: Space Grotesk
    fontSize: 28px
    fontWeight: '600'
    lineHeight: 32px
    letterSpacing: -0.03em
  headline-sm:
    fontFamily: Space Grotesk
    fontSize: 20px
    fontWeight: '600'
    lineHeight: 28px
    letterSpacing: -0.01em
  body-lg:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  body-md:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '400'
    lineHeight: 20px
  label-md:
    fontFamily: Inter
    fontSize: 13px
    fontWeight: '500'
    lineHeight: 18px
    letterSpacing: 0.01em
  label-mono:
    fontFamily: Space Grotesk
    fontSize: 11px
    fontWeight: '700'
    lineHeight: 16px
    letterSpacing: 0.08em
  caption:
    fontFamily: Inter
    fontSize: 11px
    fontWeight: '400'
    lineHeight: 14px
rounded:
  sm: 0.5rem
  DEFAULT: 1rem
  md: 1.5rem
  lg: 2rem
  xl: 3rem
  full: 9999px
spacing:
  gutter: 1.5rem
  margin: 2rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 1rem
  space-lg: 1.5rem
  space-xl: 2.5rem
---

## Brand & Style

This design system channels an uncompromising, hyper-refined automotive telematics aesthetic tailored for intelligent electric mobility ecosystems. Inspired by the intuitive clarity of premier EV operating systems (Tesla OS, Polestar, and Rivian UI), the experience balances invisible utility with precise futuristic polish. 

The aesthetic marries clinical minimalism with purposeful glassmorphism and crisp kinetic telemetry. Surfaces recede cleanly into the background, prioritizing dynamic power data, allocation availability, and spatial route feeds. Contrast is calibrated to mimic cockpit heads-up displays (HUD): calm ambient canvas foundations interrupted only by high-intensity energetic states. The emotional tone is calm, precise, effortless, and technically supreme—transforming high-voltage charging logic into a frictionless, frictionless digital interface.

## Colors

The palette relies on pure optical hierarchy: a clinical off-white canvas paired with deep obsidian/graphite typography, driven by high-voltage luminescent accents.

- **Primary Electric Cyan (`#0284C7`)**: Governs core actions, interactive selection rings, and real-time charging telemetry states. Expresses digital flow and rapid data sync.
- **Secondary Kinetic Emerald (`#10B981`)**: Dedicated exclusively to system availability, healthy stall allocation, peak battery state, and initiation triggers.
- **Tertiary Alert Coral (`#EF4444`)**: Deployed with surgical restraint for fault detection, emergency disconnect, session termination, and stall-occupied warnings.
- **Neutral Deep Obsidian (`#0F172A`)**: Provides razor-sharp contrast for bold numbers and structural text, fading systematically to muted slate (`#334155`) and secondary telemetry metadata (`#64748B`).
- **Base Canvas (`#F8FAFC`) & Pure Glass White (`#FFFFFF`)**: Establishes an expansive, glare-resistant physical plane.

## Typography

Typography establishes an automotive digital cluster feel. Space Grotesk is dedicated to primary titles and numerical telemetry readings—providing precise, machined geometry reminiscent of instrumental dashboards. Inter provides a clean, neutral, and hyper-legible body layer that dissolves into the interface.

Numerical data uses proportional/tabular lining features (`tnum`) to eliminate spatial jitter during active kilowatt (kW), battery percentage (SoC), and currency transitions. Uppercase treatments paired with generous tracking are reserved strictly for technical category labels (`label-mono`), reinforcing hardware-grade instrument clarity.

## Layout & Spacing

The layout is structured around an adaptive 12-column grid system tuned for fluid responsiveness across tablet mounts, mobile handhelds, and expansive cockpit screens. 

- **Desktop & In-Vehicle Displays (>1024px)**: 12 columns with 24px gutters and 40px outer margins. Allocates a wide, dominant telemetry quadrant alongside persistent vertical floating controls.
- **Tablet / Split-Screen (768px - 1023px)**: 8 columns with 20px gutters and 24px margins. Cards reflow into dynamic 2x2 grid blocks.
- **Mobile (<767px)**: 4 columns with 16px gutters and 16px screen margins. Content stacks linearly with full-width telemetry pods and bottom-docked glass floating bars.

Layouts avoid visual noise by leaning on generous element spacing (`space-lg` to `space-xl`) rather than physical dividing rules. Elements group naturally by relational density.

## Elevation & Depth

Visual hierarchy uses frosted glassmorphism layered over subtle tonal canvas gradations, completely eschewing opaque, heavy dropshadows.

- **Level 0 (Base Floor)**: Crisp `#F8FAFC` solid matte canvas.
- **Level 1 (Telemetry Pods & Cards)**: High-translucency pure white surfaces (`rgba(255, 255, 255, 0.75)`) backed by a 24px blur radius (`backdrop-filter: blur(24px)`) and a delicate sub-pixel top highlight (`box-shadow: inset 0 1px 0 0 rgba(255, 255, 255, 0.9)`).
- **Level 2 (Floating Cockpit Navigation & Modals)**: Translucent glass layers (`rgba(255, 255, 255, 0.85)`) supported by dual ambient dispersion: `0 20px 40px -15px rgba(15, 23, 42, 0.05), 0 0 1px 1px rgba(255, 255, 255, 0.6)`.
- **Level 3 (Interactive Active States & Glowing Nodes)**: Zero elevation drop; depth is achieved via radial chromatic emission. Active nodes emanate an 8px to 16px diffuse aura matching their operational state (Cyan `#0284C7` at 25% opacity or Emerald `#10B981` at 30% opacity).

## Shapes

The shape vocabulary uses expansive, ultra-smooth continuous curves. Primary actions, state tags, and floating nav anchors use full pill forms (`border-radius: 9999px`), delivering a tactile, ergonomic surface suited for rapid touch interaction.

Functional containers, dashboard cards, and allocation bays use large radii (2rem to 3rem), echoing automotive exterior panels and aerodynamic industrial profiles. Micro-components such as data chips and input rows utilize proportional soft-pill contours, preserving continuous continuity across the system.

## Components

### Buttons
- **Primary Kinetic Action**: Full pill shape, filled in glowing Electric Cyan (`#0284C7`) or Emerald (`#10B981`) with crisp white Space Grotesk text. Features a faint outer halo under hover and touch actuation.
- **Ghost Action**: Pill contour with a semi-translucent glass border (`border: 1px solid rgba(15, 23, 42, 0.08)`), transparent fill, and graphite text (`#0F172A`). Fills to light frosted white on hover.
- **Emergency Halt Button**: Pill-shaped Alert Coral (`#EF4444`) with high-contrast reverse type, accompanied by a vibrating optical pulse in warning states.

### Cards & Telemetry Containers
- Borderless construction relying on soft white glass surfaces (`rgba(255, 255, 255, 0.75)`).
- Interior layouts are clean: bold numerical metrics top-aligned, accompanied by upper-tracked `label-mono` indicators. Dividers are eliminated; negative space dictates hierarchy.

### Status Indicator Dots & Glow Nodes
- 8px circular nodes embedded within pill chips.
- Available/Charging/Fault states emit a continuous, soft CSS pulse animation with a matching color shadow (`box-shadow: 0 0 12px <color>`).

### Battery & Power Telemetry Indicators
- Horizontal segment bars with smoothed pill ends.
- Background uses subtle slate track fills (`rgba(15, 23, 42, 0.04)`), while the active gauge fills with continuous gradient transitions from Kinetic Emerald into Electric Cyan based on charging velocity.

### Input Fields & Selectors
- Recessed pill-shaped containers with translucent `#FFFFFF` fills, inset borders (`1px solid rgba(15, 23, 42, 0.06)`), and floating micro-labels. Focus shifts the stroke to Electric Cyan with zero layout shift.

### Minimalist Digital Receipts
- Edge-to-edge frosted glass ticket layout featuring dashed laser-perforated vector breaks, tabular Space Grotesk pricing breakdowns, and an integrated high-contrast dynamic QR allocation code.